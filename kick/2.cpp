#include <bits/stdc++.h>
using namespace std;
#define ll long long int
#define ld long double
#define ii pair<int,int>
#define iii pair<ii,int>
#define vii vector<ii>
#define vi vector<int>
#define vvi vector<vi>
#define vll vector<ll>
#define vvll vector<vll>
#define vs vector<string>
#define pb push_back
#define mp make_pair
#define fi first
#define se second
#define nu 100000
#define mod 1000000007
#define inf pow(10,9)
// #define h pow(10,-8)
#define fastio ios_base::sync_with_stdio(false);cin.tie(0);cout.tie(0)

int main()
{
	fastio;
	int Q;
	cin >> Q;

	for(int q=1;q<=Q;++q)
	{
		int n, k;
		cin >> n >> k;
		vll p(n), h(n), x(k), y(k), a(4), b(4), c(4), m(4);

		cin >> p[0] >> p[1] >> a[0] >> b[0] >> c[0] >> m[0];
		cin >> h[0] >> h[1] >> a[1] >> b[1] >> c[1] >> m[1];
		cin >> x[0] >> x[1] >> a[2] >> b[2] >> c[2] >> m[2];
		cin >> y[0] >> y[1] >> a[3] >> b[3] >> c[3] >> m[3];

		for (int i = 2; i < n; ++i)
		{
			p[i] = c[0];
			p[i] = (p[i]+a[0]*p[i-1])%m[0];
			p[i] = (p[i]+b[0]*p[i-2])%m[0]+1;
		}

		for (int i = 2; i < n; ++i)
		{
			h[i] = c[1];
			h[i] = (h[i]+a[1]*h[i-1])%m[1];
			h[i] = (h[i]+b[1]*h[i-2])%m[1]+1;
		}

		for (int i = 2; i < k; ++i)
		{
			x[i] = c[2];
			x[i] = (x[i]+a[2]*x[i-1])%m[2];
			x[i] = (x[i]+b[2]*x[i-2])%m[2]+1;
		}

		for (int i = 2; i < k; ++i)
		{
			y[i] = c[3];
			y[i] = (y[i]+a[3]*y[i-1])%m[3];
			y[i] = (y[i]+b[3]*y[i-2])%m[3]+1;
		}

		int ans = 0;

		for (int i = 0; i < k; ++i)
		{
			ll bx = x[i], by = y[i], hy;

			for (int j = 0; j < n; ++j)
			{
				if(bx <= p[j])
				{
					hy = by+p[j]-bx;
					if(hy <= h[j] && hy >= 0)
					{
						ans++;
						break;
					}
				}
				else
				{
					hy = by-p[j]+bx;
					if(hy <= h[j] && hy >= 0)
					{
						ans++;
						break;
					}	
				}
			}
		}

		cout << "Case #" << q << ": " << ans << '\n';
	}
}	