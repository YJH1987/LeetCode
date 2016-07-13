public class MostWater {
    public int maxArea(int[] height) {
        int area = 0;
        int left = 0;
        int right = height.length - 1;
        while(left <= right){
            int tmp = (right - left) * Math.min(height[left], height[right]);
            area = Math.max(area, tmp);
            if(height[left] <= height[right]) 
                left++;
            else
                right--;
        }
        return area;
    }
}
