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
public class BinaryTree<T> {

    private NodeTree root;
    private int height;
    private int elements;

    public BinaryTree() {
        this.root = null;
        this.height = - 1;
        this.elements = 0;
    }

    public boolean isEmpty() {
        return (root.left == null && root.right == null);
    }

    public void insert(int data) {
        NodeTree node = new NodeTree(data);
        if (root == null) {
            root = node;
            return;
        } else {
            NodeTree aux = root;
            NodeTree parent = null;
            while (true) {
                parent = aux;
                if (data < aux.data) {
                    aux = aux.left;
                    if (aux == null) {
                        parent.left = node;
                        return;
                    }
                } else {
                    aux = aux.right;
                    if (aux == null) {
                        parent.right = node;
                        return;
                    }
                }
            }
        }
        /*NodeTree node = new NodeTree(data);
        //Si esta vacio, el nodo se convierte en la raiz
        if (isEmpty(root)) {
            root = node;
            this.height++;
        } else //Si el nodo es mayor que la raiz
         if (root.data <= node.data) {
                //Si no tiene elementos a la izq.
                if (root.left == null) {//Caso base (hasta que encuentre un lugar vacio en la izquierda)
                    root.left = node;
                } else {//Si tiene elementos a la izquierda
                    //Buscara a la izquierda hasta encontrar un espacio
                    insert(data, root.left);
                }

            } else //Si el nodo es menor que la raiz
             if (root.right == null) {//Caso base (hasta que encuentre un lugar vacio en la derecha)
                    root.right = node;
                } else {
                    insert(data, root.right);
                }
        this.elements++;*/
    }

    /**
     * Method to empty the whole Binary Tree
     */
    public void eTree() {
        root = null;
    }

    /**
     *
     * @param data the id for the node it is looking for
     * @return the Node containing the data, or null, if it isn't found
     */
    public NodeTree searchNode(int data) {
        if (root == null) {
            return null;
        } else {
            NodeTree aux = root;
            //Mientras no se acaben los nodos
            while (aux != null) {
                //Regresa el nodo que se ingreso
                if (aux.data == data) {
                    return aux;
                }
                //Se busca a la izquierda
                if (data < aux.data) {
                    aux = aux.left;
                } else {
                    //Se busca a la derecha
                    aux = aux.right;
                }
            }
            return null;//Si no se encuentra nodo
        }
    }

    public boolean eNode(int data) {
        NodeTree parent = root;
        NodeTree aux = root;
        boolean isLeft = false;
        //Mientras el nodo no sea igual al que se quiere encontrar
        while (aux.data != data) {
            //Se declara al padre como el nodo actual
            parent = aux;
            //Se analiza si data es mayor o menor que el data a la izquierda o derecha del nodo actual
            if (data < aux.data) {
                isLeft = true;
                aux = aux.left;
            } else {
                isLeft = false;
                aux = aux.right;
            }
            //Si llega al final no se encontro el nodo
            if (aux == null) {
                return false;
            }
        }
        //Se encontro el nodo
        //Se analiza si el nodo no tiene ramas
        if (aux.right == null && aux.left == null) {
            //Si es la raiz se borra el arbol
            if (aux == root) {
                eTree();
            }
            //Se borra el nodo actual, desde su padre, dependiendo si es a la izquierda o derecha
            if (isLeft) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else if (aux.right == null) {//Si tiene un hijo a la izquierda
            //Se sube el hijo de la izquierda (si es raiz)
            if (aux == root) {
                root = aux.left;
            } else if (isLeft) {
                parent.left = aux.left;
            } else {
                parent.right = aux.left;
            }
        } else if (aux.left == null) {//Si tiene un hijo a la derecha
            if (aux == root) {
                root = aux.right;
            } else if (isLeft) {
                parent.left = aux.right;
            } else {
                parent.right = aux.right;
            }
        } else if (aux.left != null && aux.right != null) {//Si tiene hijos en ambos lado
            //encontramos el elemento menor del lado derecho del arbol
            NodeTree next = getNext(aux);
            if (aux == root) {
                aux = next;
            } else if (isLeft) {
                parent.left = next;
            } else {
                parent.right = next;
            }
            next.left = aux.left;
        }
        return true;
    }

    /**
     *
     * @return the node that's on the root of the tree
     */
    public NodeTree getRoot() {
        return root;
    }

    /**
     *
     * @return height (the total levels of all the nodes)
     */
    public int getHeight() {
        return height;
    }

    /**
     *
     * @return elements (number of nodes)
     */
    public int getElements() {
        return elements;

    }

    /**
     * Method to print the tree inOrder (left-center-right)
     */
    public void printInOrder(NodeTree node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(node.data + ", ");
            printInOrder(node.right);
        }
    }

    /**
     * Method to print the tree preOrder (center-left-right)
     */
    public void printPreOrder(NodeTree node) {
        if (node != null) {
            System.out.print(node.data + ", ");
            printInOrder(node.left);
            printInOrder(node.right);
        }
    }

    /**
     * Method to print the tree postOrder (left-right-center)
     */
    public void printPostOrder(NodeTree node) {
        if (node != null) {
            System.out.print(node.data + ", ");
            printInOrder(node.right);
            printInOrder(node.left);
        }
    }

    private NodeTree getNext(NodeTree node) {
        NodeTree next = null;
        NodeTree parentNext = null;
        NodeTree aux = node.right;
        while (aux != null) {
            parentNext = next;
            next = aux;
            aux = aux.left;
        }
        if (next != node.right) {
            parentNext.left = next.right;
            next.right = node.right;
        }
        return next;
    }
}
