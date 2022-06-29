package com.harmony.demo.controllers.item;

public class ItemNotFoundException extends RuntimeException{
    ItemNotFoundException(Long id) {
        super("Could not find item " + id);
      }
}
