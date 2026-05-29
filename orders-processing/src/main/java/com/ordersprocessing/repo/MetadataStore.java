package com.ordersprocessing.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ordersprocessing.model.FileMetadata;

@Component
public class MetadataStore {

    public static List<FileMetadata> metadataList =
            new ArrayList<>();
}
