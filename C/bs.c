#include <stdio.h>
#include <stdlib.h>

#define LEN 10

void
sort(int *a, int len) {
  // 对数组a进行排序
  // 冒泡排序
  int i, j, tmp = 0;
  for (i = 0; i < len; i++) {
    for (j = i+1; j < len; j++) {
      if (a[i] > a[j]) {
        tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
      }
    }
  }
}

int
bs(int key, int *a, int len) {
  // 判断key是否在数组a中
  // 非递归版本
  int lo = 0;
  int hi = len-1;

  while(lo <= hi) {
    int mid = lo + (hi-lo)/2;
    if (key == a[mid]) { return 1; }
    else if (key > a[mid]) {
      lo = mid+1; // +1, 去掉mid
    }
    else if (key < a[mid]) {
      hi = mid-1; // -1, 去掉mid
    }
  }
  return -1;
}

int
sub_bsd(int key, int *a, int lo, int hi) {
  // 递归版本
  int mid = lo + (hi-lo)/2;
  if (lo > hi) {
    return -1;
  }
  if (key == a[mid]) { return 1; }
  else if (key > a[mid]) {
    return sub_bsd(key, a, mid+1, hi);
  }
  else if (key < a[mid]) {
    return sub_bsd(key, a, lo, mid-1);
  }
}

int
bsd(int key, int *a, int len) {
  // 判断key是否在数组a中
  // 递归版本
  int lo = 0;
  int hi = len-1;
  return sub_bsd(key, a, lo, hi);
}

int
main(int argc, char **argv) {
    int i, res1, res2 = 0;
    int a[LEN] = {1, 2, 2, 10, 30, 4, 8, 9, 1, 29};
    sort(a, LEN);

    for (i = 0; i < LEN; i++) {
      printf("%d ", a[i]);
    }
    printf("\n");

    res1 = bs(3, a, LEN);
    res2 = bs(2, a, LEN);
    printf("3: %d\n", res1);
    printf("2: %d\n", res2);

    res1 = bsd(3, a, LEN);
    res2 = bsd(2, a, LEN);
    printf("3: %d\n", res1);
    printf("2: %d\n", res2);

    return 0;
}
