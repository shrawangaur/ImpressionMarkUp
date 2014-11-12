package com.crest.service;

import com.crest.model.Document;

import java.util.ArrayList;
import java.util.List;

public class ImpressionServiceThread extends Thread {
    private static List<Document> pendingDocumentList = new ArrayList<Document>();

    public static void addDocumentToMarkImpression(Document _document) {
        pendingDocumentList.add(_document);
    }

    @Override
    public void run() {
        try {
            while (true) {
                List<Document> processingQueue = new ArrayList<Document>(pendingDocumentList);
                pendingDocumentList = new ArrayList<Document>();

                for (Document document : processingQueue) {
                    document.setImpressionMarkProperty(document.markImpression());
                }
                Thread.sleep(100);
            }
        } catch (Exception _ex) {
            //TODO : Log
        }
    }

    public static List<Document> getPendingDocumentList() {
        return pendingDocumentList;
    }

 }
