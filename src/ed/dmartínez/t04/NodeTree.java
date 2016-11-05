/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.dmartínez.t04;

/**
 *
 * @author danx_
 */
public class NodeTree<T> {
    int data;
    NodeTree left;
    NodeTree right;
    
    public NodeTree(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
