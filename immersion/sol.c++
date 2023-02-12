#include <cstdlib>
#include <cstdio>
#include <cstring>
#include <algorithm>
using namespace std;

const int maxN=1000100;
int n;
char A[maxN],B[maxN],C[maxN],cmpAB[maxN];
int left[10],sameB[maxN];
bool checkLeft(int d) {
	left[d]--;
	int cmp=0,pos=n;
	for(int i=0;i<=9;i++)
	    if(left[i]) {
			if(cmp=i-B[pos])
				break;
			if(sameB[pos]<left[i]) {
				cmp=i-B[pos-sameB[pos]];break;
			}
			pos-=left[i];
		}
		
	if(cmp==0&&(cmp=d-B[pos--])==0)
	    cmp=cmpAB[pos];
	left[d]++;
	return cmp<0;
}
bool peek(int left[],int d,int pos,int &type,int &cur,int &data,int &len) {
	if(type==1) {
        while(cur<=9&&left[cur]==0)
			cur++;
		if(cur<=9) {
            data=cur,len=left[cur];
            return true;
		} else
			type=2;
	}
	if(type==2)
	    if(d>=0) {
	        data=d,len=1;
	        return true;
		} else
		    type=3,cur=pos;
	if(type==3)
		if(cur<=n) {
			data=B[cur],len=1;
			return true;
		}
	return false;
}
void fetch(int left[],int d,int pos,int &type,int &cur,int len) {
    if(type==1)
		left[cur]-=len;
	else if(type==2)
	    type=3,cur=pos;
	else
	    cur++;
}
int cmpRight(const int _left1[],int d1,int pos1,const int _left2[],int d2,int pos2) {
	int left1[10],left2[10];
	memcpy(left1,_left1,sizeof(left1));
	memcpy(left2,_left2,sizeof(left2));

	int type1=1,cur1=0,type2=1,cur2=0;
	for(;;) {
		int data1,len1,data2,len2;
		if(!peek(left1,d1,pos1,type1,cur1,data1,len1)||!peek(left2,d2,pos2,type2,cur2,data2,len2)||(type1==3&&type2==3))
		    return 0;
		if(data1!=data2)
		    return data1-data2;

		len1=min(len1,len2);
		fetch(left1,d1,pos1,type1,cur1,len1);
		fetch(left2,d2,pos2,type2,cur2,len1);
	}
}
int main() {
		scanf("%d%s%s%s",&n,A+1,B+1,C+1);
		for(int i=1;i<=n;i++)
		    A[i]-='0';
	    for(int i=1;i<=n;i++)
		    B[i]-='0';
		memset(left,0,sizeof(left));
	    for(int i=1;i<=n;i++)
		    left[C[i]-'0']++;

		int cmp=0;
		for(int i=1;i<=n;i++)
		    if(cmp=A[i]-B[i])
		        break;
		if(cmp<0)
		    for(int i=1;i<=n;i++)
		        swap(A[i],B[i]);
		cmp=0;
		for(int i=n;i>=1;i--)
		    if(cmp=A[i]-B[i])
		        break;
		if(cmp<0)
		    memcpy(B+1,A+1,sizeof(A[0])*n);
		for(int i=1;i<=n;i++)
		    sameB[i]=(i==1||B[i]!=B[i-1])?1:(sameB[i-1]+1);
	
		cmpAB[0]=0;
		for(int i=1;i<=n;i++)
		    if((cmpAB[i]=A[i]-B[i])==0)
		        cmpAB[i]=cmpAB[i-1];

		int posL=0,dL;
		while(posL<n-1&&left[(int)A[posL+1]])
	        --left[(int)A[++posL]];
		for(;posL>=0;posL--) {
			dL=-1;
			for(int i=9;i>A[posL+1];i--)
			    if(left[i]) {
					dL=i;break;
				}
			if(dL>=0&&checkLeft(dL)) {
			    break;
			}
			if(posL)
			    ++left[(int)A[posL]];
		}
		bool sol=false;
		if(posL>=0) {
	        for(int i=A[posL+1]+1;i<=9;i++)
			    if(left[i]&&checkLeft(i)) {
					dL=i;break;
				}
			--left[dL];
			int cmpLeft=(dL-B[posL+1])?(dL-B[posL+1]):cmpAB[posL];

			int leftAns[10],dRAns,posRAns=-1;
			for(int posR=n+1;posL+2<=posR;posR--) {
				if(posR<=n&&(--left[(int)B[posR]])<0)
					break;
				if(posL+2==posR) {
					if(cmpLeft<0)
					    if(posRAns<0||cmpRight(left,-1,posR,leftAns,dRAns,posRAns)<0) {
					        memcpy(leftAns,left,sizeof(leftAns));
					        dRAns=-1;
					        posRAns=posR;
						}
				} else {
					int dR=-1;
					for(int i=B[posR-1]-1;i>=0;i--)
					    if(left[i]) {
							dR=i;break;
						}
					if(dR>=0) {
						--left[dR];
						if(posRAns<0||cmpRight(left,dR,posR,leftAns,dRAns,posRAns)<0) {
						    memcpy(leftAns,left,sizeof(leftAns));
						    dRAns=dR;
						    posRAns=posR;
						}
						++left[dR];
					}
				}
			}
			if(posRAns>=0) {
				sol=true;
				for(int i=1;i<=posL;i++)
				    putchar(A[i]+'0');
				putchar(dL+'0');
				for(int i=0;i<=9;i++)
				    while(leftAns[i]--)
				        putchar(i+'0');
				if(dRAns>=0)
				    putchar(dRAns+'0');
	            for(int i=posRAns;i<=n;i++)
				    putchar(B[i]+'0');
				puts("");
			}
		}
		if(!sol)
		    puts("-1");
}