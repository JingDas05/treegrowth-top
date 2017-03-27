package top.treegrowth.provider.serviceImpl.batch;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.context.annotation.Configuration;

/**
 * @author wusi
 * @version 2017/3/20 21:31
 */
@Configuration
public class JobListener extends JobExecutionListenerSupport {

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            System.out.println("batch 开始清理工作开始了");
            String setKey = jobExecution.getJobParameters().getString("setKey");
        }
    }
}
