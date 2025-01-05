package ForumHub.Api.Forum;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ForumRepository extends JpaRepository <Forum, Long> {


}
