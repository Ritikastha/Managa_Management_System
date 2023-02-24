package com.example.Manga_Management.services.impl;

import com.example.Manga_Management.Entity.Menu;



import com.example.Manga_Management.repo.MenuRepository;

import com.example.Manga_Management.services.MenuService;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    private MenuRepository menuRepository;

    public MenuServiceImpl(MenuRepository menuRepository) {
        super();
        this.menuRepository = menuRepository;
    }

    @Override
    public List<Menu> getAllMenu() {
        return menuRepository.findAll();
    }




    @Override
    public Menu saveMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public Menu getMenuById(Long id) {
        return menuRepository.findById(id).get();
    }

    @Override
    public Menu updateMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public void deleteMenuById(Long id) {
        menuRepository.deleteById(id);
    }


    }
