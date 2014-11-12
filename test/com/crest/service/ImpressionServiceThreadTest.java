package com.crest.service;

import junit.framework.Assert;

import org.junit.Test;

import com.crest.model.Book;
import com.crest.model.Document;

public class ImpressionServiceThreadTest {

    @Test
    public void testIfDocumentGettingAddedForImpressionMark() {
        Document book = createBook();
        ImpressionServiceThread.addDocumentToMarkImpression(book);
        Assert.assertTrue(ImpressionServiceThread.getPendingDocumentList().contains(book));
    }


    @Test
    public void testIfDocumentIsMakedWithImpression() throws InterruptedException {
        ImpressionServiceThread serviceThread = new ImpressionServiceThread();
        Document book = createBook();
        ImpressionServiceThread.addDocumentToMarkImpression(book);
        serviceThread.start();
        Thread.sleep(5000);
        String s = book.getImpressionMarkProperty();
        Assert.assertEquals("{content:\"book\",title:\"Test Title\",author:\"Test Author\",topic:\"Business\"}", s);
        Assert.assertTrue(book.isImpressionMarked());
    }

    private Document createBook() {
        Document book = new Book("Test Title", "Test Author", "Business");
        return book;
    }
}
