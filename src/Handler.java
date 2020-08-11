
import java.awt.Graphics;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mucah
 */
public class Handler {

    LinkedList<GameObject> object = new LinkedList<GameObject>();

    public void tick(){
        for(int i = 0; i < object.size(); i++){
            GameObject tempObject = object.get(i);
            tempObject.tick();
        }
    }

    public void render(Graphics g){
        for(int i = 0; i < object.size(); i++){
            GameObject tempObject = object.get(i);
            tempObject.render(g);
        }
    }

    public void clearEnemys(){

        for(int i = 0; i < object.size(); i++){
            GameObject tempObject = object.get(i);

            if(tempObject.getId() == ID.Player){

                if(Game.gameState == Game.STATE.End){
                    remove(tempObject);
                    i--;
                }
            }
            else{
                remove(tempObject);
                i--;
            }


        }


//        else{
//            for(int i = 0; i < object.size(); i++){
//                GameObject tempObject = object.get(i);
//
//                if(tempObject.getId() != ID.Player){
//                    remove(tempObject);
//                    i--;
//                }
//            }
//        }

//        for(int i = 0; i < object.size(); i++){
//            GameObject tempObject = object.get(i);
//
//            if(tempObject.getId() != ID.Player){
//                remove(tempObject);
//                i--;
//                if(Game.gameState == Game.STATE.End){
//                    object.clear();
//                }
//            }
//        }

    }

    public void addObject(GameObject object){
        this.object.add(object);
    }

    public void remove(GameObject object){
        this.object.remove(object);
    }


}
