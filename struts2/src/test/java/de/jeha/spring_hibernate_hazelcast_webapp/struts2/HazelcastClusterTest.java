package de.jeha.spring_hibernate_hazelcast_webapp.struts2;

import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.perf4j.LoggingStopWatch;
import org.perf4j.StopWatch;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.hazelcast.core.Hazelcast;

import de.jeha.spring_hibernate_hazelcast_webapp.struts2.bl.GenericDao;
import de.jeha.spring_hibernate_hazelcast_webapp.struts2.entities.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext-test.xml" })
@Transactional
public class HazelcastClusterTest {

    @Resource
    private GenericDao genericDao;

    @Test
    public void foobar() {
        final int elemCount = 100 * 1000;
        final Random generator = new Random();
        StopWatch stopWatch = new LoggingStopWatch();

        Map<String, String> map = Hazelcast.getMap("values");

        for (int i = 0; i < elemCount; i++) {
            map.put(Integer.toString(i), "value" + i);
        }
        stopWatch.stop("done putting 100.000 elements into a map");

        stopWatch.start();
        for (int i = 0; i < elemCount; i++) {
            int idx = generator.nextInt(elemCount) + 1;
            map.get(Integer.toString(idx));
        }
        stopWatch.stop("done retrieving 100.000 random elements from a map");
    }

    @Ignore
    @Test
    @Rollback(false)
    public void setupTestData() {
        User u = new User();
        u.setUsername("u" + System.currentTimeMillis());
        genericDao.persist(u);
    }
}
