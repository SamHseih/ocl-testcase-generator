% ------------- grade_path.ecl -------------
:- lib(ic).             % 區間約束 
		
sum_list(L, Sum) :-
    ( foreach(X, L),               % 相當於 OCL 的「elem」
      fromto(0,  S0, S1, Sum)     % 相當於「acc = init | acc'」  
    do
        S1 #= S0 + X              % 相當於「expr」部份
    ).
	

array_data(Result,List):-
dim(Result, List), 
term_variables_array(Result, Vars), 
Vars #:: 1 .. 4, alldifferent(Vars), 
(foreachelem(Ele, Vars) do indomain(Ele, random)).
