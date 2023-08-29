/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.hangmangame;

/**
 *
 * @author peace
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author peace
 */

public class HangmanGame {
   private  int warnings;
   public String words;
   public int length;
   public  int totalguesses;


   public HangmanGame (){
       warnings = 4;
       
       String storedwords[] = {"optimal", "design" , "object" , "horse"};
       Random r = new Random();
       int random = r.nextInt(4);

       words = storedwords[random];
       length = words.length();
       totalguesses = (int) (1.5*length);
       
       System.out.println("Welcome to the Hangman!");
       System.out.println("I am thinking of " + length+ " word");
       System.out.println("You have " + warnings + " warnings ");
       System.out.println("You have total " + totalguesses + " guesses ");
   }
   
   public void userguesses(){
       int i, index, counter=0;

       Scanner sc = new Scanner(System.in);
       ArrayList<String> letters = new ArrayList<>();
       String sword[] = words.split("");
       for(String s:sword)
           letters.add(s);

       String alphabets = "abcdefghijklmnopqrstuvwxyz";
       String salphabets [] = alphabets.split("");


       ArrayList<String> alphabet = new ArrayList<>();
       for(String temp1:salphabets)
           alphabet.add(temp1);

       ArrayList<String> Guessed = new ArrayList<>();
       
       ArrayList<String> exist = new ArrayList<>();

       for(int k = 0 ; k<length ; k++){
           Guessed.add(k, "_");
       }
       for( i=totalguesses; i>=1 ; i--){
           System.out.println("You have " + i + " guesses left ");
           System.out.println("Available letters: " + alphabet + "\n");
           System.out.println("Please guess a letter: ");
           String usersguess = sc.next();
           usersguess = usersguess.toLowerCase();
           char temp3 = usersguess.charAt(0);
           
        if(Character.isAlphabetic(temp3)){
               usersguess = Character.toString(temp3);
            if(exist.contains(usersguess)){
                   System.out.println("Oops! You've already guessed that letter. You have "+ warnings+" warnings left");
                   warnings--;
                   i++;

               }
               else  if(letters.contains(usersguess)){
                   
                   alphabet.remove(usersguess);
                   exist.add(usersguess);
                   index = letters.indexOf(usersguess);
                   Guessed.remove(index);
                   Guessed.add(index , usersguess);



                   counter++;
                   i++;
                   System.out.println("Good guess: " + Guessed);
                   if(counter==length){
                       System.out.println("You Won ");
                       break;

                   }
               }
               else {
                   System.out.println("Try some other letter from available letters ");
                   alphabet.remove(usersguess);
               }
            
           }

         
           else
           {
               System.out.println("NOT VALID!");
               warnings--;
               i++;


           }
          
       }
       if((i<=0&&counter!=length)||(i<0&&counter==0)){
           System.out.println(" You Lost ");}




   }

   public static void main(String args[]){

       HangmanGame hangman = new HangmanGame();


       hangman.userguesses();


   }


}