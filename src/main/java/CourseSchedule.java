package main.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 有向无环图DAG，  ***
 * 利用入度做广度优先遍历
 */
public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree=new int[numCourses];
        List<List<Integer>> list = new ArrayList<>(numCourses);
        for(int i=0;i<numCourses;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            int[] edge= prerequisites[i];
            inDegree[edge[0]]=inDegree[edge[0]]+1;
            list.get(edge[1]).add(edge[0]);
        }

        int finishCourse = 0;
        Queue<Integer> queue= new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            finishCourse++;
            int course = queue.poll();
            inDegree[course]--;
            for(Integer node:list.get(course)){
                if(--inDegree[node] ==0){
                    queue.add(node);
                }
            }
        }
        return finishCourse==numCourses;
    }


}

