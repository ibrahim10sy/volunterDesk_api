package product_owner.volunteeDeskApi.repositories;

import product_owner.volunteeDeskApi.models.Notification;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
