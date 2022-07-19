// From a technical interview with an AWS engineer: https://youtu.be/t0OQAD5gjd8

/* 
  Given an unsorted non-empty array of integers and int k, return the k most frequent elements (in any order)
  You can assume there is always a valid solution
  These example inputs are sorted for readability, but the input is NOT guaranteed to be sorted and the output does NOT need to be in any specific order
  Hard Bonus: make it O(n) time
*/

const nums4 = [1, 2, 1, 1, 2, 3]; // [1, 1, 1, 2, 2, 3]
const k1 = 2; // First 2 most frequent number
// expected1 = [1, 2];
// Explanation: return the two most frequent elements, 1 and 2 are the two most frequent elements

const nums5 = [0, 2,0, 0, 2, 3]; // [0,0,0,2,2,3]
const k2 = 1; // most frequent number
// expected2 = [0];
// Explanation: k being 1 means return the single most frequent element

const nums6 = [1, 2, 3, 1, 2,  3]; // [1, 1, 2, 2, 3, 3]
const k3 = 3;
// expected3 = [1, 2, 3];
/* 
  Explanation: 3 is the only value that would be passed in for k because it is the only value for k that has
  a valid solution. Since 1, 2, and 3, all occur 3 times, they are all the most frequent ints, so there is no
  1 most frequent int, or 2 most frequent int, but there are 3 most frequent ints. 
*/

/**
 * Returns the k most frequently occurring numbers from the given unordered
 * nums.
 * - Time: O(?).
 * - Space: O(?).
 * @param {Array<number>} nums Unordered.
 * @param {number} k Represents the amount of numbers that should be returned.
 * @returns {Array<number>} The k most frequently occurring numbers.
 */
 function kMostFrequent(nums, k) {
    var new_arr = []
    var dict = {}
    var num = 0;
    var greatest = 1;
    var index;
    while(num != k){
      for (let i = 0; i < nums.length; i++){
        if(greatest < dict[nums[i]]){
          greatest = dict[nums[i]];
          index = nums[i];
        }
        if (dict.hasOwnProperty(nums[i])){
          dict[nums[i]] += 1;
        }else {
          dict[nums[i]] = 1;
        }
      }
      new_arr.push(dict[index])
      greatest = 0;
      num++;
    }
    // for (let i = 0; i < num + 1; i++){
    //   if ()
    // }
    return new_arr;
  }
  console.log(kMostFrequent(nums4, k1))
  console.log(kMostFrequent(nums5, k2))