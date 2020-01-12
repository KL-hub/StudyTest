package com.lixiang.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Description //图
 * @Author 李项
 * @Date 2020/1/12
 * @Version 1.0
 */
public class Graph {
    /**
     *图的深度优先遍历
     *1）访问的起始结点v，并标记结点v已访问
     * 2）查找v的第一个邻接结点w
     * 3)若w存在，则继续执行4,若w不存在，则回到第一步，将从v的下一个结点继续
     * 4）若w未被访问，对w进行深度优先遍历递归(即把w当做另一个v，然后进行步骤123)
     * 5）查找结点v的w邻接结点的下一个邻接结点，转到步骤3
     */
    private ArrayList<String> vertexList; //存储结点集合
    private int[][] edages;   //存储图对应得邻接矩阵
    private int numOfEdages; //表示边的个数
    private boolean [] isVisited=new boolean [5];

    public static void main(String[] args) {
        //测试图是否创建成功
        int n=5;
        String vertexValues[]={"A","B","C","D","E"};
        Graph graph = new Graph(vertexValues.length);
        for (String vertexValue : vertexValues) {
            graph.insertVertex(vertexValue);
        }
        //添加边
        graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);

        graph.showGraph();
      /*  System.out.println("深度优先算法");
        graph.dfs();*/
        System.out.println("广度优先算法");
        graph.bfs();
    }
    //构造器
    public Graph(int n){
        //初始化
        edages=new int[5][5];
        vertexList=new ArrayList<String> ();
        numOfEdages=0;
        isVisited=new boolean [n];
    }
    /**
     * 得到第一个邻接节点的下标w
     * @param index
     * @return
     */
    public int getFirstNeighbor(int index){
        for (int i = 0; i < vertexList.size(); i++) {
            if(edages[index][i]>0){
                return i;
            }
        }
        return -1;
    }

    /**
     * 根据前一个邻接结点的下标来获取下一个邻接结点
     * @param v1
     * @param v2
     * @return
     */
    public int getNextNeight(int v1,int v2){
        for (int i = v2+1; i < vertexList.size(); i++) {
            if(edages [v1] [i] >1){
                return i;
            }
        }
        return -1;
    }
    //深度优先遍历算法
    private void  dfs(boolean [] isVisited,int i){
        System.out.println(getValueByIndex(i)+"->");
        //将结点设置为已访问
        isVisited [i] =true;
        //查找结点i的第一个邻接结点w
        int w= (i);
        while (w!=-1){
            if(!isVisited[w]){//说明没有被访问过
                dfs(isVisited,w);
            }
            w=getNextNeight(i,w);
        }
    }
    //对一个结点进行广度优先遍历的方法
    private void bfs(boolean [] isVisited,int i){
        int u;//表示队列的头结点对应下标
        int w; //邻接结点w
        //队列，记录结点访问的顺序
        LinkedList queue=new LinkedList();
        //访问结点，输出结点信息
        System.out.println(getValueByIndex(i)+"=>");
        //标记为已访问
        isVisited[i]=true;
        //将结点加入到队列
        queue.addLast(i);
        while (!queue.isEmpty()){
            //取出队列的头结点下标
            u=(Integer) queue.removeFirst();
            //得到第一个邻接结点的下标w
            w=getFirstNeighbor(u);
            while (w!=-1) {
                if(!isVisited [w]){
                    System.out.println(getValueByIndex(w)+"=>");
                    //标记已访问
                    isVisited [w] =true;
                    //入队列
                    queue.addLast(w);
                }
                //已访问过（以u为前驱点，找w后面的下一个邻结点）
                w=getNextNeight(u,w);
            }
        }

    }
    //遍历所有的结点，都进行广度优先搜索
    public void bfs(){
        for (int i = 0; i < getNumOfVertex(); i++) {
            if(!isVisited [i]){
                bfs(isVisited,i);
            }
        }
    }
    //对dfs，进行一个重载，比那里我们所有的结点，并进行dfs
    public void dfs(){
        //遍历所有的结点，进行dfs[回溯]
        for (int i = 0; i < getNumOfVertex(); i++) {
            if(!isVisited [i]){
                dfs(isVisited, i);
            }
        }
    }
    private String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    //显示图对应得矩阵
    public void showGraph(){
        for (int[] edage : edages) {
            System.out.println(Arrays.toString(edage));
        }
    }
    //返回结点的个数
    public int getNumOfVertex(){
        return vertexList.size();
    }
    //返回边的个数
    public int getNumOfEdages(){
        return numOfEdages;
    }
    //插入结点
    public void  insertVertex(String vertex){
        vertexList.add(vertex);
    }
    //插入边
    public void insertEdge(int v1,int v2,int weight){
        edages[v1][v2]=weight;
        edages[v2][v1]=weight;
        numOfEdages++;
    }
}
