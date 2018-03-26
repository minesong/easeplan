package com.ease.service;

import com.ease.model.PurItem;

import java.util.List;

public interface PurItemService {
    List<PurItem> getAllPurItems();

    Long addPurItem(Long id);
}
