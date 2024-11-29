/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author aclew
 */
public class PlayGame 
{
    public static void main(String[] args) 
    {
        ArrayList<Player> players = new ArrayList<>();
        Game g = new Game("WAR");
        System.out.println("Welcome to "+ g.getName());
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter player 1 name: ");
        String name = sc.next();
        players.add(new Player(name));
        System.out.println("Enter player 2 name: ");
        String name1 = sc.next();
        players.add(new Player(name1));
        g.setPlayers(players);
        g.play();
        
           Player winner = g.getWinner();
           if(winner == null) System.out.println("It's a Tie");
           else System.out.println(winner.getName() + " is the Winner");
    }
}
