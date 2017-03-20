package top.treegrowth.provider.serviceImpl.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author wusi
 * @version 2017/3/18 16:22
 */
@Component
@EnableScheduling
public class ScheduleCustom {

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job job;

    /**
     * cron 现在是每15s执行一次
     * <p>
     * job执行的入口，相同的job和step执行之后，batchStatus会变成complicated,不会再执行
     * 传入jobParameters ,参数是当前时间，这样每次调用都会执行，用jobParametersBuilder生成jobParameters
     */
//    @Scheduled(cron = "0/15 * * * * *")
    public void calculateHotScore() {
        try {
            jobLauncher.run(job, new JobParametersBuilder().addDate("time", new Date()).toJobParameters());
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("批量更新出现问题，请检查batch");
        }
    }

}
