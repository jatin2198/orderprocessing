package com.ordersprocessing.config;




import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

import org.springframework.stereotype.Component;

import com.ordersprocessing.repo.MetadataStore;

@Component
public class BatchJobListener
        implements JobExecutionListener {

    @Override
    public void beforeJob(
            JobExecution jobExecution) {

        String filePath =
                jobExecution
                        .getJobParameters()
                        .getString("filePath");

        updateStatus(
                filePath,
                "PROCESSING");

        System.out.println(
                "Batch Started");
    }

    @Override
    public void afterJob(
            JobExecution jobExecution) {

        String filePath =
                jobExecution
                        .getJobParameters()
                        .getString("filePath");

        if(jobExecution.getStatus()
                == BatchStatus.COMPLETED) {

            updateStatus(
                    filePath,
                    "COMPLETED");

            System.out.println(
                    "Batch Completed");
        }

        else {

            updateStatus(
                    filePath,
                    "FAILED");

            System.out.println(
                    "Batch Failed");
        }
    }

    private void updateStatus(
            String filePath,
            String status) {

        MetadataStore
        .metadataList
                .stream()

                .filter(meta ->
                        filePath.contains(
                                meta.getFileName()))

                .findFirst()

                .ifPresent(meta ->
                        meta.setStatus(status));
    }
}