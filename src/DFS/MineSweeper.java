package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class MineSweeper {
	public static void main(String[] args) {
		char[][] input = new char[][] {
				{ 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E' },
				{ 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E' },
				{ 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E' },
				{ 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E' },
				{ 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E' },
				{ 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E' },
				{ 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E' },
				{ 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E' },
				{ 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E' },
				{ 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E' },
				{ 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E' },
				{ 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E' },
				{ 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E' },
				{ 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E' },
				{ 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E' },
				{ 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E' },
				{ 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E' },
				{ 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E' },
				{ 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E' },
				{ 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E' },
				{ 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E' },
				{ 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E' },
				{ 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E' },
				{ 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E' },
				{ 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E' },
				{ 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E' },
				{ 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E' },
				{ 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E' },
				{ 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E' },
				{ 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E' },
				{ 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E' },
				{ 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E' },
				{ 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E' },
				{ 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E' },
				{ 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E' },
				{ 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E' },
				{ 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E' },
				{ 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E' },
				{ 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E' },
				{ 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E' },
				{ 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E' },
				{ 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E' },
				{ 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E' },
				{ 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E' },
				{ 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E' },
				{ 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E' },
				{ 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E' },
				{ 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E' },
				{ 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E' },
				{ 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
						'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E' }

		};
		char[][] output = updateBoard(input, new int[] { 0, 0 });
		for (char[] out : output) {
			System.out.println(Arrays.toString(out));
		}

	}

	public static char[][] updateBoard(char[][] board, int[] click) {
		if (board[click[0]][click[1]] == 'M') {
			board[click[0]][click[1]] = 'X';
			return board;
		}
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(click);
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			if(board[temp[0]][temp[1]]!='M' && board[temp[0]][temp[1]]!='E' &&  board[temp[0]][temp[1]]!='X') {
				continue;
			}
			List<int[]> adj = getUnvisitedAdjacent(board, temp);
			int countMines = getMineCount(adj, board);
			if (countMines > 0) {
				board[temp[0]][temp[1]] = Character.forDigit(countMines, 10);

			} else {
				board[temp[0]][temp[1]] = 'B';
				for (int[] a : adj) {
					q.offer(a);
				}
			}
		}
		return board;
	}

	private static int getMineCount(List<int[]> adj, char[][] grid) {
		int count = 0;
		for (int[] pos : adj) {
			if (grid[pos[0]][pos[1]] == 'M') {
				count++;
			}
		}
		return count;
	}

	public static List<int[]> getUnvisitedAdjacent(char[][] grid, int[] click) {
		List<int[]> adj = new ArrayList<int[]>();
		int totalCol = grid[0].length;
		int totalRow = grid.length;

		int col = click[1];
		int row = click[0];
		if (col >= 0 && col < totalCol && row >= 0 && row < totalRow) {

			if (row - 1 >= 0) {
				int[] arr = addIfNotRevealed(grid, new int[] { row - 1, col });
				if (arr != null) {
					adj.add(arr);
				}
			}
			if (row + 1 < totalRow) {
				int[] arr = addIfNotRevealed(grid, new int[] { row + 1, col });
				if (arr != null) {
					adj.add(arr);
				}
			}

			if (col - 1 >= 0) {
				int[] arr = addIfNotRevealed(grid, new int[] { row, col - 1 });
				if (arr != null) {
					adj.add(arr);
				}
			}
			if (col + 1 < totalCol) {
				int[] arr = addIfNotRevealed(grid, new int[] { row, col + 1 });
				if (arr != null) {
					adj.add(arr);
				}
			}
			if (row - 1 >= 0 && col - 1 >= 0) {
				int[] arr = addIfNotRevealed(grid, new int[] { row - 1, col - 1 });
				if (arr != null) {
					adj.add(arr);
				}
			}
			if (row + 1 < totalRow && col + 1 < totalCol) {
				int[] arr = addIfNotRevealed(grid, new int[] { row + 1, col + 1 });
				if (arr != null) {
					adj.add(arr);
				}
			}
			if (row - 1 >= 0 && col + 1 < totalCol) {
				int[] arr = addIfNotRevealed(grid, new int[] { row - 1, col + 1 });
				if (arr != null) {
					adj.add(arr);
				}
			}
			if (row + 1 < totalRow && col - 1 >= 0) {
				int[] arr = addIfNotRevealed(grid, new int[] { row + 1, col - 1 });
				if (arr != null) {
					adj.add(arr);
				}
			}
		}
		return adj;
	}

	public static int[] addIfNotRevealed(char[][] grid, int[] pos) {
		if (grid[pos[0]][pos[1]] == 'M' || grid[pos[0]][pos[1]] == 'E') {
			return pos;
		} else {
			return null;
		}
	}
}
