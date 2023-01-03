package com.jira.AccoliteJiraBackend.Service;


import com.jira.AccoliteJiraBackend.Base.Sprint;
import com.jira.AccoliteJiraBackend.Exceptions.NoObjectException;
import com.jira.AccoliteJiraBackend.Repository.SprintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class SprintService {

    @Autowired
    private SprintRepository sprintRepository;

    public Sprint addSprints(Sprint st) {
        st.setCurrent(true);
        return sprintRepository.save(st);
    }

    public Sprint viewSprint(long sprintId) throws NoObjectException {

        Optional<Sprint> sprintObj = this.sprintRepository.findById(sprintId);

        if (sprintObj.isPresent()) {
            return sprintObj.get();
        } else {
            throw new NoObjectException("No Such Sprints Found");
        }
    }

    public List<Sprint> viewSprints() {

        return this.sprintRepository.findAll();
    }


}

