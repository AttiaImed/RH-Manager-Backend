package com.mission.RHManager.Services.Impl.Reclamation;

import com.mission.RHManager.Entites.FeedBack;
import com.mission.RHManager.Entites.Utilisateur;
import com.mission.RHManager.Repositories.FeedBackRepository;
import com.mission.RHManager.Repositories.UtilisateurRepository;
import com.mission.RHManager.Services.Reclamation.FeedBackService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedBackServiceImpl implements FeedBackService {

    private final FeedBackRepository feedbackRepository;
    private final UtilisateurRepository utilisateurRepository;

    @Override
    public FeedBack addFeedback(FeedBack feedBack) {
        Object
                principal
                = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if
        (principal
                instanceof
                UserDetails) {
            UserDetails
                    userDetails
                    = (UserDetails) principal;
            String
                    username
                    = userDetails.getUsername();
// use username or userDetails as needed

            // create local date for the system time
            LocalDate ld = LocalDate.now();
            Utilisateur u1 = utilisateurRepository.findByEmail(username).orElse(null);
            //Utilisateur u2 = utilisateurRepository.findById(feedBack.getUtilisateurManagerFeedBack().getId()).orElse(null);
            feedBack.setDateSoumission(ld);

            feedBack.setUtilisateurEmployeFeedBack(u1);
            //feedBack.setUtilisateurManagerFeedBack(u2);
            FeedBack fCreated = feedbackRepository.save(feedBack);
            fCreated.getUtilisateurEmployeFeedBack().setPassword(null);
//            fCreated.getUtilisateurManagerFeedBack().setPassword(null);
            return fCreated;
        }else {
            String
                    username
                    = principal.toString();
// handle cases where the principal is not an instance of UserDetails
            return null;
        }
    }

    @Override
    public FeedBack updateFeedBack(FeedBack feedBack) {
        FeedBack f = feedbackRepository.findById(feedBack.getId()).orElse(null);
        f.setTypeFeedBack(feedBack.getTypeFeedBack());
        f.setLibelle(feedBack.getLibelle());
        f.setDescription(feedBack.getDescription());
        return feedbackRepository.save(f);
    }


    @Override
    public void deleteFeedBack(Long id) {
        feedbackRepository.deleteById(id);
    }

    @Override
    public FeedBack getFeedBack(Long id) {
        return feedbackRepository.findById(id).get();
    }

    @Override
    public List<FeedBack> getAllFeedBack() {
        return feedbackRepository.findAll();
    }
    @Override
    public List<FeedBack> getUserFeedBack(long id) {
        Utilisateur user = utilisateurRepository.findById(id).get();
        return feedbackRepository.findByUtilisateurEmployeFeedBack(user);
    }
}
