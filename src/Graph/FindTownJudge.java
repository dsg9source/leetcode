package Graph;

public class FindTownJudge {
	//https://leetcode.com/problems/find-the-town-judge/submissions/
	public static void main(String[] args) {
		int[][] trust= {};
		System.out.println(findJudge(2, trust));
	}

	public static int findJudge(int N, int[][] trust) {

		int[][] adjMat = new int[N+1][N+1];
		if(trust.length==0) {
			if(N==1) {
				return 1;
			}else {
				return -1;
			}
		}
		for (int i = 0; i < trust.length; i++) {
			int[] edge=trust[i];
			adjMat[edge[0]][edge[1]]=1;
		}
		for(int i=1;i<N+1;i++) {
			boolean isCandidateJudge=true;
			for(int j=1;j<N+1;j++) {
				if(adjMat[i][j]!=0) {
					isCandidateJudge=false;
					break;
				}
			}
			if(isCandidateJudge) {
				boolean isJudge=true;
				int j=i;
				for(int k=1;k<N+1;k++) {
					if(k==j) {
						continue;
					}
					if(adjMat[k][j]!=1){
						isJudge=false;
						break;
					}
				}
				if(isJudge) {
					return i;
				}
			}
		}
		return -1;
	}
}
