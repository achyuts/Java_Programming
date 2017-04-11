// Given an unsorted array print the duplicate values.

void findDuplicates(int[] arr){
	if(arr == null || arr.length ==0 )
		return;
	
	Set<Integer> set = new HashSet<Integer>();
	int val;
	for(int i=0; i<arr.length; i++){
		val = arr[i];
		if(set.contains(val)){
			System.out.println(val);
		} else {
			set.add(val);
		}
	}
}


Test Cases:
1) []
2) [1,2,3,4,5]
3) [1,1,1,1,1]
4) [1,2,3,4,1]
5) [1]
6) [1,2,1,2,1,3]



// Given a balanced expression, find duplicate brackets.
eg. ((a+b)) True

eg. (a) False
eg. () False
eg. (()) True
eg. ((a)) True
eg. (a)() False
eg. ((a)+b) False
eg. ((a+b)+(c)) 
eg. (((a))), ((((a+b)))), 
eg. (((a)+b)+c)
eg. ((a+b)+(a-b)+c)
eg. (a+(b)+c)
eg. (b+(-)+(a))



boolean checkForDuplicateBrackets(char[] c){
	if(c == null || c.length == 0)
		return false;
	
	Stack<Boolean> stack = new Stack<Boolean>();
	for(int i=0; i<c.length; i++){
		
		// if value is not a close bracket we push value in stack and continue
		if(c[i] != ')'){
			stack.push(c[i]);
			continue;
		} 
		
		// if char value is a closed bracket we check the values int the stack. 
		if(c[i] == ')') {
			int count = 0;
			while(stack.size() >0 ){
				char ch = stack.pop();
				count++;
				if(ch == '(')
					break;
			}
			if(count == 1){
				return true;
			}			
		}	
		
	}
	return false;
}




// We are given a rotated sorted array with distinct elements, search an element (return the index).

int seachInRotatedSortedArray(int[] arr, int element){
	
	if(arr == null || arr.length == 0)
		return -1;
	
	int start = 0;
	int end = arr.length - 1;
	
	while(start <= end) {
		int mid = start + (end-start)/2;
		
		if(arr[mid] == element)
			return mid;
		
		if(arr[mid] > arr[start]) {
			if(element >= arr[start] && element < arr[mid])
				end = mid-1;
			else
				start = mid+1;
		} else {
			if(element > arr[mid] && element <= arr[end])
				start = mid+1;
			else
				end = mid-1;
		
		}
	
	}
	
	return -1;

}

test cases:
1) [1,2,3,4] , (1, 4, 2)
2) [4,1,2,3] , (4,3,1)
3) [2,3,1], (1,3,2)
4) 






