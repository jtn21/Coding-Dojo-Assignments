const numsOrdered = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
const numsRandomOrder = [9, 2, 5, 6, 4, 3, 7, 10, 1, 8];
const numsReversed = [10, 9, 8, 7, 6, 5, 4, 3, 2, 1];
const expected = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];



function insertionSort(nums) {
    let n = nums.length
    for(let i = 1;i < n; i++ ) {
      
      let current = nums[i];
      let j = i-1;
      while ((j > -1) && (current < nums[j])) {
        nums[j+1] = nums[j];
        j--;
      }
      nums[j+1] = current
    }
    return nums
  }
  // it works. 
  console.log(insertionSort(numsOrdered));
  console.log(insertionSort(numsRandomOrder));
  console.log(insertionSort(numsReversed));
  console.log(insertionSort(expected));