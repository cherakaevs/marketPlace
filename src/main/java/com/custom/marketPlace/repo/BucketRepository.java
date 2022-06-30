package com.custom.marketPlace.repo;

import com.custom.marketPlace.model.Bucket;
import com.custom.marketPlace.model.Product;
import com.custom.marketPlace.model.Profile;

import java.util.List;
import java.util.UUID;

public interface BucketRepository {
    Bucket getBucketById(UUID id);
    Bucket getBucketByCustomer(Profile customer);
    Bucket saveBucket(Bucket b);
    void removeBucket(Bucket b);
    void updateBucketProducts(UUID id, List<Product> products);
}
