package com.fsdprogram.demo.controllers.item;

public class ItemNotFoundException extends RuntimeException{
    ItemNotFoundException(Long id) {
        super("Could not find item " + id);
      }
}
