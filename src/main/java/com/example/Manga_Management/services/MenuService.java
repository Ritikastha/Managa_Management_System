package com.example.Manga_Management.services;

import com.example.Manga_Management.Entity.Menu;



import java.util.List;

public interface MenuService {
    List<Menu> getAllMenu();

    Menu saveMenu(Menu menu);

    Menu getMenuById(Long id);

    Menu updateMenu(Menu menu);

    void deleteMenuById(Long id);
}
