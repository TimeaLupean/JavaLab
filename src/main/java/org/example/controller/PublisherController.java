package org.example.controller;

import org.example.main.Publisher;
import org.example.repository.PublisherRepository;

import java.util.List;

public class PublisherController {

    private PublisherRepository publisherRepository;

    public PublisherController(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public void createPublisher(int publisherId, String name, String address, int fiscalCode) {
        Publisher publisher = new Publisher(publisherId, name, address, fiscalCode);
        publisherRepository.save(publisher);
    }

    public Publisher findPublisherById(int publisherId) {
        return publisherRepository.findById(publisherId);
    }

    public List<Publisher> viewAllPublishers() {
        return publisherRepository.findAll();
    }

    public void updatePublisher(int publisherId, String name, String address, int fiscalCode) {
        Publisher updatedPublisher = new Publisher(publisherId, name, address, fiscalCode);
        publisherRepository.update(updatedPublisher);
    }

    public void deletePublisher(int publisherId) {
        publisherRepository.delete(publisherId);
    }
}
