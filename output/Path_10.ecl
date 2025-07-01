:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(random).


solving_Path_10(Self,Arg,DimensionSizes,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_data],Arg=[Arg_data],Result = [Result_data],
Dim1#> 0 ,Dim2#> 0 ,Dim3#> 0 ,labeling_Dim([Dim1, Dim2, Dim3]),DimensionSizes = [Dim1, Dim2, Dim3],
dim(Self_data,[Dim1, Dim2, Dim3]),dim(Arg_data,[Dim1, Dim2, Dim3]),dim(Result_data,[Dim1, Dim2, Dim3]),

%CLG Path Constrints,
getDimensionSizes(Self_data, 3, Var_1891502635),
getDimensionSizes(Self_data, 2, Var_1571967156),
getDimensionSizes(Self_data, 1, Var_574568002),
(((Var_574568002 #> 0),
(Var_1571967156 #> 0)),
(Var_1891502635 #> 0)),
getDimensionSizes(Arg_data, 1, Var_952486988),
(D1 = Var_952486988),
getDimensionSizes(Arg_data, 2, Var_932285561),
(D2 = Var_932285561),
getDimensionSizes(Arg_data, 3, Var_2028555727),
(D3 = Var_2028555727),
(Acc = true),
(Idx0 #= 1),
(Idx0 #=< D1 - 1+ 1),
sueuencetolist(1,D1,List_168366),nth1(Idx0,List_168366,Var_168366),(It = Var_168366),
(Acc2 = true),
(Idx1 #= 1),
(Idx1 #=< D2 - 1+ 1),
sueuencetolist(1,D2,List_1780034814),nth1(Idx1,List_1780034814,Var_1780034814),(It2 = Var_1780034814),
(Acc3 = true),
(Idx2 #= 1),
(Idx2 #=< D3 - 1+ 1),
sueuencetolist(1,D3,List_1360657223),nth1(Idx2,List_1360657223,Var_1360657223),(It3 = Var_1360657223),
(Var_1905485420_1 is Arg_data[It,It2,It3]),(Var_551479935_1 is Self_data[It,It2,It3]),(Var_58940486_1 is Result_data[It,It2,It3]),(Var_58940486_1 #= (Var_551479935_1+Var_1905485420_1)),
(Idx2_1 #= (Idx2+1)),
(Idx2_1 #=< D3 - 1+ 1),
sueuencetolist(1,D3,List_1360657223),nth1(Idx2_1,List_1360657223,Var_1360657223_1),(It3_1 = Var_1360657223_1),
(Var_1905485420_2 is Arg_data[It,It2,It3_1]),(Var_551479935_2 is Self_data[It,It2,It3_1]),(Var_58940486_2 is Result_data[It,It2,It3_1]),(Var_58940486_2 #= (Var_551479935_2+Var_1905485420_2)),
(Idx2_2 #= (Idx2_1+1)),
(Idx2_2 #> D3 - 1+ 1),
(Idx1_1 #= (Idx1+1)),
(Idx1_1 #> D2 - 1+ 1),
(Idx0_1 #= (Idx0+1)),
(Idx0_1 #> D1 - 1+ 1),

%Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
