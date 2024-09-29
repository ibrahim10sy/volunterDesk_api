package product_owner.volunteeDeskApi.services;

import product_owner.volunteeDeskApi.models.Notification;
import product_owner.volunteeDeskApi.repositories.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public Notification save(Notification notification) {
        return notificationRepository.save(notification);
    }

    public Notification update(Notification n , Long id){
        Notification no =  notificationRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucune notification trouvé"));
        no.setContenuNotification(n.getContenuNotification());
        return n;
    }
    
    public List<Notification> findAll(){
        return notificationRepository.findAll();
    }

    public Notification findById(Long id) {
        Notification n =  notificationRepository.findById(id).orElseThrow(() -> new IllegalStateException("Aucune notification trouvé"));
        return n;
    }

    public void deleteById(Long id) {
        notificationRepository.deleteById(id);
    }
}
