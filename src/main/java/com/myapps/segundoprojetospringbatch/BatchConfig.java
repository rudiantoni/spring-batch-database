package com.myapps.segundoprojetospringbatch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@EnableBatchProcessing
@Configuration
public class BatchConfig {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    public BatchConfig(
            JobBuilderFactory jobBuilderFactory,
            StepBuilderFactory stepBuilderFactory) {

        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
    }

    @Bean
    public Job printHelloJob() {

        return jobBuilderFactory
                .get("printHelloJob")
                .start(printHelloStep())
                /*
                Allows runs the job everytime the application is run
                You'll need to clear the metadata at the first time you run with this parameter.
                You can also set a unique parameter in the application command line.
                */
                .incrementer(new RunIdIncrementer())
                .build();
    }

    public Step printHelloStep() {
        return stepBuilderFactory
                .get("printHelloStep")
                .tasklet(printHelloTasklet(null))
                .build();
    }

    @Bean
    @StepScope
    public Tasklet printHelloTasklet(@Value("#{jobParameters['name']}") String name) {
        return new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
                System.out.println(String.format("\n\n\nHello %s!\n\n\n", name));
                return RepeatStatus.FINISHED;
            }
        };
    }

}
