/**
 * 
 */
package com.clps.bj.mms.common.util.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;





/**
 * Name:MyTree
 * Function: 对树的增删改查. 
 * Reason:	 分类 树. 
 * Date:     2018年1月15日
 * author   ygg 
 * 	 
 */
/**
 * @author ygg
 *
 */

public class MyTree<T> {
	private Node root; // 存放根
	
	


	/**
	 * @return the root
	 */
	public final Node getRoot() {
		
		return root;
	}

	/**
	 * @param root the root to set
	 */
	public final void setRoot(T t) {
		this.root = new Node();
		this.root.value = t;
	}

	public MyTree() {
		root = new Node();
		this.root.height = 0;
	}

	public MyTree(Node root) {
		this.root = root;
		this.root.height = 1;
	}

	// 返回深度
	public Integer height() {
		return root.height;
	}
	
	/**
	 * 删除树
	 * @param deleteTree 要删除的树
	 * @return booelan 
	 */
	public  boolean deleteTree(){
		boolean isSuc =true;
		Node parentNode = this.root.parentNode;
		ArrayList<Node> nodes = parentNode.childrenNodes;
		System.out.println(nodes.remove(this));

		
		updateHeightByDelete(parentNode);
		//updateHeight(parentNode.parentNode, parentNode);
		this.root.parentNode = null;
		
		
		return isSuc;
	}
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public boolean equals(Object obj) {
		
		return ((MyTree.Node)obj).value.equals(this.root.value);
	}

	/**
	 * 遍历树
	 * @return ArrayList<T>
	 */
	public ArrayList<T> getTree() {
		ArrayList<T> results = new ArrayList<>();

		getTreeByNode(root, results);
		return results;
	}

	private void getTreeByNode(Node currentNode, ArrayList<T> results) {
		if (currentNode != null) {
			results.add(currentNode.value);
			ArrayList<Node> children = currentNode.childrenNodes;
			if(children != null){
				for (Node node : children) {
					getTreeByNode(node, results);
				}
			}
		}
	}
	
	
	
	
	
	/**
	 * 查找对象对象的树
	 * @param 要查找的对象
	 * @return MyTree
	 */
	public MyTree  queryOne(T t){
		if(this.root.value.equals(t)){
			return this;
		}
		for(Node n:this.root.childrenNodes){
			if(n.value.equals(t)){
				return new MyTree<>(n);
			}
		}
		return null;
	}
	
	
	/**
	 * 遍历父树及自己
	 * @param 要查找的对象
	 * @return MyTree
	 */
	public ArrayList<T>  getParentTrees(MyTree<T> myTree){
		ArrayList<T> results = null;
		if(myTree != null){
			Node parentNode = myTree.root.parentNode;
			
			results = new ArrayList<>();
			Node currentNode = myTree.root;
			while(currentNode != null){
				results.add(currentNode.value);
				currentNode = currentNode.parentNode;
				
			}
			
			
		}
		
		
		if(results != null){
			 Collections.reverse(results); 
		}
		
		return results;
	}
	
	/**
	 * 添加树
	 * @param parentTree 父树节点
	 * @param childTree 子树节点
	 * @return  boolean
	 */
	public boolean addTree( MyTree<T> childTree) {

		boolean isSuc = true; // 标记是否成功
		this.root.childrenNodes.add(childTree.root);
		childTree.root.parentNode = this.root;
		updateHeight(this.root, childTree.root);
		return isSuc;
	}
	
	
	
	
	
	
	/**
	 * 返回操作后的深度
	 * @param parentNode 父树
	 * @param childNode  子树
	 * @return int 
	 */
	private int updateAfterOfHeight(Node parentNode, Node childNode) {
		
		return ( parentNode.height - 1 < childNode.height ? (childNode==null?0:childNode.height + 1) : parentNode.height);
	}
	
	/**
	 * 递归修改树
	 * @param parentTree
	 * @param childTree
	 */
	private  void updateHeight(Node parentTree, Node childTree) {
		while (parentTree != null) {
			// 获取当前修改的树的节点的深度
			parentTree.height = updateAfterOfHeight(parentTree, childTree);
			// 移动接点，从子节点往父节点移动
			childTree = parentTree;
			parentTree = parentTree.parentNode;
		}
	}
	
	
	
	/**
	 * 删除递归修改树
	 * @param parentTree
	 * @param childTree
	 */
	private  void updateHeightByDelete(Node parentTree) {
		Node childTree = null;
		while (parentTree != null) {
			// 获取当前修改的树的节点的深度
			ArrayList<Node> children = parentTree.childrenNodes;
			int max = 0;
			if(children != null && children.size()>0){
				for(Node n:children){
					max = n.height>max?n.height:max;
				}
			}
			
			parentTree.height = max+1;
			// 移动接点，从子节点往父节点移动
			childTree = parentTree;
			parentTree = parentTree.parentNode;
		}
	}
	
	
	
	
	//节点内部类
	private class Node {
		private T value;     //树的值
		private Integer height;  //树的深度
		private Node parentNode;  //父节点
		private ArrayList<Node> childrenNodes;  //子节点

		private Node() {
			this.height = 1;
			childrenNodes = new ArrayList<>();
		}
				
		private Node(T t) {
			this.value = t;
			childrenNodes = new ArrayList<>();
		}
		
		
		
	}
	
	
}
