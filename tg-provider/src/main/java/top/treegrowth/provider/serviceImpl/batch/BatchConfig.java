package top.treegrowth.provider.serviceImpl.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import top.treegrowth.provider.serviceImpl.batch.model.In;
import top.treegrowth.provider.serviceImpl.batch.model.Out;
import top.treegrowth.provider.serviceImpl.batch.step.ItemProcess;
import top.treegrowth.provider.serviceImpl.batch.step.ItemReaderCus;
import top.treegrowth.provider.serviceImpl.batch.step.ItemWriterCus;

/**
 * @author wusi
 * @version 2017/3/18 8:38.
 */
@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Bean
    public Job calculateJob() {
        return jobBuilderFactory.get("jobName")
                .incrementer(new RunIdIncrementer())
                .start(caseHostScoreStep())
                .build();
    }

    @Bean
    private Step caseHostScoreStep() {
        return stepBuilderFactory.get("stepName")
                .<In, Out>chunk(50)
                .reader(reader().getReader("getDreamBy", "wusi", "123456"))
                .processor(process())
                .writer(writer())
                .build();
    }

    @Scope("step")
    @Bean
    private ItemReaderCus reader() {
        return new ItemReaderCus();
    }

    @Scope("step")
    @Bean
    private ItemProcess process() {
        return new ItemProcess();
    }

    @Scope("step")
    @Bean
    private ItemWriterCus writer() {
        return new ItemWriterCus();
    }
}
