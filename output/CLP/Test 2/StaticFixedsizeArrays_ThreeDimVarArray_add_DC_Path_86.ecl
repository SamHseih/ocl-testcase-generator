:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(random).


solving_Path_86(Self,Arg,DimensionSizes,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_data],Arg=[Arg_data],Result = [Result_data],
Dim1#> 0 ,Dim2#> 0 ,Dim3#> 0 ,labeling_Dim([Dim1, Dim2, Dim3]),DimensionSizes = [Dim1, Dim2, Dim3],
dim(Self_data,[Dim1, Dim2, Dim3]),dim(Arg_data,[Dim1, Dim2, Dim3]),dim(Result_data,[Dim1, Dim2, Dim3]),

%CLG Path Constrints,
getDimensionSizes(Self_data, 3, Var_2143437117),
getDimensionSizes(Self_data, 2, Var_802600647),
getDimensionSizes(Self_data, 1, Var_1543148593),
(((Var_1543148593 #> 0),
(Var_802600647 #> 0)),
(Var_2143437117 #> 0)),
getDimensionSizes(Arg_data, 1, Var_1571967156),
(D1 = Var_1571967156),
getDimensionSizes(Arg_data, 2, Var_574568002),
(D2 = Var_574568002),
getDimensionSizes(Arg_data, 3, Var_952486988),
(D3 = Var_952486988),
(Acc = true),
(Idx0 #= 1),
(Idx0 #=< D1 - 1+ 1),
sueuencetolist(1,D1,List_2065857933),nth1(Idx0,List_2065857933,Var_2065857933),(It = Var_2065857933),
(Acc2 = true),
(Idx1 #= 1),
(Idx1 #=< D2 - 1+ 1),
sueuencetolist(1,D2,List_1914301543),nth1(Idx1,List_1914301543,Var_1914301543),(It2 = Var_1914301543),
(Acc3 = true),
(Idx2 #= 1),
(Idx2 #=< D3 - 1+ 1),
sueuencetolist(1,D3,List_1157726741),nth1(Idx2,List_1157726741,Var_1157726741),(It3 = Var_1157726741),
(Var_1708570683_1 is Arg_data[It,It2,It3]),(Var_225472281_1 is Self_data[It,It2,It3]),(Var_817348612_1 is Result_data[It,It2,It3]),(Var_817348612_1 #= (Var_225472281_1+Var_1708570683_1)),
(Idx2_1 #= (Idx2+1)),
(Idx2_1 #=< D3 - 1+ 1),
sueuencetolist(1,D3,List_1157726741),nth1(Idx2_1,List_1157726741,Var_1157726741_1),(It3_1 = Var_1157726741_1),
(Var_1708570683_2 is Arg_data[It,It2,It3_1]),(Var_225472281_2 is Self_data[It,It2,It3_1]),(Var_817348612_2 is Result_data[It,It2,It3_1]),(Var_817348612_2 #= (Var_225472281_2+Var_1708570683_2)),
(Idx2_2 #= (Idx2_1+1)),
(Idx2_2 #> D3 - 1+ 1),
(Idx1_1 #= (Idx1+1)),
(Idx1_1 #=< D2 - 1+ 1),
sueuencetolist(1,D2,List_1914301543),nth1(Idx1_1,List_1914301543,Var_1914301543_1),(It2_1 = Var_1914301543_1),
(Acc3_1 = true),
(Idx2_3 #= 1),
(Idx2_3 #=< D3 - 1+ 1),
sueuencetolist(1,D3,List_1157726741),nth1(Idx2_3,List_1157726741,Var_1157726741_2),(It3_2 = Var_1157726741_2),
(Var_1708570683_3 is Arg_data[It,It2_1,It3_2]),(Var_225472281_3 is Self_data[It,It2_1,It3_2]),(Var_817348612_3 is Result_data[It,It2_1,It3_2]),(Var_817348612_3 #= (Var_225472281_3+Var_1708570683_3)),
(Idx2_4 #= (Idx2_3+1)),
(Idx2_4 #=< D3 - 1+ 1),
sueuencetolist(1,D3,List_1157726741),nth1(Idx2_4,List_1157726741,Var_1157726741_3),(It3_3 = Var_1157726741_3),
(Var_1708570683_4 is Arg_data[It,It2_1,It3_3]),(Var_225472281_4 is Self_data[It,It2_1,It3_3]),(Var_817348612_4 is Result_data[It,It2_1,It3_3]),(Var_817348612_4 #= (Var_225472281_4+Var_1708570683_4)),
(Idx2_5 #= (Idx2_4+1)),
(Idx2_5 #> D3 - 1+ 1),
(Idx1_2 #= (Idx1_1+1)),
(Idx1_2 #> D2 - 1+ 1),
(Idx0_1 #= (Idx0+1)),
(Idx0_1 #> D1 - 1+ 1),

%Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
