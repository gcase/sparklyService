package com.gcase;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class SparkleService {

    private Map<String, SparkleSummary> storage = new HashMap<>();

    public SparkleSummary addSparkle(String user, Optional<String> reason) {

        SparkleSummary ss = getSparkleSummary(user);

        ss.setSparkles(ss.getSparkles() + 1);
        if (reason.isPresent()) {
            ss.getPositives().add(reason.get());
        }

        return ss;

    }

    public SparkleSummary getSparkleSummary(String user) {
        SparkleSummary ss;
        if (storage.containsKey(user)) {
            ss = storage.get(user);
        } else {
            ss = new SparkleSummary();
            ss.setName(user);
            storage.put(user, ss);
        }
        return ss;
    }

    public SparkleSummary removeSparkle(String user, Optional<String> reason) {
        SparkleSummary ss = getSparkleSummary(user);

        ss.setSparkles(ss.getSparkles() - 1);
        if (reason.isPresent()) {
            ss.getNegatives().add(reason.get());
        }

        return ss;
    }

}
