package com.techsolution.restaurant.dao;


public interface FileLoaderMapper <T> {
    public void loadAndGetRecords();
    public void loadAndGetHeader();
}
