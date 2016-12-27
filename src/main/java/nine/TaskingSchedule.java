package nine;

import java.util.Arrays;
import java.util.Comparator;

public class TaskingSchedule {
	// n is the number of task ,m is the whole space ,
	// r is the operation space array , o is the storage space array
	boolean isTaskable(int n, int m, int[] r, int[] o) {
		TagTask[] tasks = new TagTask[n];
		for (int i = 0; i < n; i++) {
			tasks[i].taskId = i;
			tasks[i].RO = r[i] - o[i];
		}

		// descendingly sort the tasks according the task RO
		MyCompare cmp = new MyCompare();
		Arrays.sort(tasks, cmp);

		// then check if the m can satisfy the procedure
		int k;
		for (int i = 0; i < n; i++) {
			k = tasks[i].taskId;
			if (r[k] <= m) {
				System.out.print(k);
				m -= o[k];
			} else {
				return false;
			}
		}
		return true;
	}
}

class TagTask {
	int taskId;
	// RO = r[id] - o[id]
	int RO;
}

class MyCompare implements Comparator<TagTask> {
	// use Comparator to implement the defined sort
	// http://blog.csdn.net/jason_deng/article/details/7026458

	@Override
	public int compare(TagTask o1, TagTask o2) {
		// TODO Auto-generated method stub
		return o1.RO < o2.RO ? 1 : -1;
	}

}
