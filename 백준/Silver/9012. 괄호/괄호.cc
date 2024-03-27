#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <cstring>
#include <queue>
#include <stack>

using namespace std;


int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	
	int n;
	cin >> n;
	string answer;

	for (int i = 0; i < n; i++)
	{
		stack <int> stack;
		string a;
		cin >> a;
		int size = a.size();
		bool check = false;
		for (int j = 0; j < size; j++)
		{
			if (a[j] == ')')
			{
				if (stack.empty())
				{
					check = true;
					break;
				}
				else
					stack.pop();
			}
			else if (a[j] == '(')
			{
				stack.push(1);
			}
		}
		if (!stack.empty() || check == true)
			answer = "NO";
		else
			answer = "YES";
		cout << answer << endl;
	}

}