/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.reservadequartosleonardo;

import com.mycompany.ferramentas.Formularios;
import com.mycompany.visao.outros.empresarial.MenuPrincipal;

/**
 *
 * @author leonardo.35903
 */
public class Reservadequartosleonardo {

    public static void main(String[] args) {
        if (Formularios.menuPrincipal == null)
            Formularios.menuPrincipal = new MenuPrincipal();
        
        Formularios.menuPrincipal.setVisible(true);
    }
}
