:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

staticFixedsizeArrays_Cube_add_DCC_Path_220(Self,Arg,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_data,Self_dimensionSizes],Self_dimensionSizes = [2, 2, 2],
Arg=[Arg_data,Arg_dimensionSizes],Arg_dimensionSizes = [2, 2, 2],
Result = [Result_data,Result_dimensionSizes],Result_dimensionSizes = [2, 2, 2],

decl_Array(Self_data,Self_dimensionSizes),
decl_Array(Arg_data,Arg_dimensionSizes),
decl_Array(Result_data,Result_dimensionSizes),

[]#::(-32768)..32767,
%CLG Path Constrints,
nth1(1,Arg_dimensionSizes,Var_1546693040),
(Dim1 = Var_1546693040),
nth1(2,Arg_dimensionSizes,Var_1984990929),
(Dim2 = Var_1984990929),
nth1(3,Arg_dimensionSizes,Var_1105423942),
(Dim3 = Var_1105423942),
(Acc = true),
(Index0 #= 1),
(Index0 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_558216562),nth1(Index0,List_558216562,Var_558216562),(It = Var_558216562),
(Acc2 = true),
(Index1 #= 1),
(Index1 #=< Dim2 - 1+ 1),
sequencetoList(1,Dim2,List_961712517),nth1(Index1,List_961712517,Var_961712517),(It2 = Var_961712517),
(Acc3 = true),
(Index2 #= 1),
(Index2 #> Dim3 - 1+ 1),
(Index1_1 #= (Index1+1)),
(Index1_1 #=< Dim2 - 1+ 1),
sequencetoList(1,Dim2,List_961712517),nth1(Index1_1,List_961712517,Var_961712517_1),(It2_1 = Var_961712517_1),
(Acc3_1 = true),
(Index2_1 #= 1),
(Index2_1 #> Dim3 - 1+ 1),
(Index1_2 #= (Index1_1+1)),
(Index1_2 #> Dim2 - 1+ 1),
(Index0_1 #= (Index0+1)),
(Index0_1 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_558216562),nth1(Index0_1,List_558216562,Var_558216562_1),(It_1 = Var_558216562_1),
(Acc2_1 = true),
(Index1_3 #= 1),
(Index1_3 #=< Dim2 - 1+ 1),
sequencetoList(1,Dim2,List_961712517),nth1(Index1_3,List_961712517,Var_961712517_2),(It2_2 = Var_961712517_2),
(Acc3_2 = true),
(Index2_2 #= 1),
(Index2_2 #=< Dim3 - 1+ 1),
sequencetoList(1,Dim3,List_1928931046),nth1(Index2_2,List_1928931046,Var_1928931046),(It3 = Var_1928931046),
getArrayElement(Arg_data,[It_1,It2_2,It3],Var_1034568234_1),getArrayElement(Self_data,[It_1,It2_2,It3],Var_835227336_1),getArrayElement(Result_data,[It_1,It2_2,It3],Var_482082765_1),(Var_482082765_1 #= (Var_835227336_1+Var_1034568234_1)),
(Index2_3 #= (Index2_2+1)),
(Index2_3 #=< Dim3 - 1+ 1),
sequencetoList(1,Dim3,List_1928931046),nth1(Index2_3,List_1928931046,Var_1928931046_1),(It3_1 = Var_1928931046_1),
getArrayElement(Arg_data,[It_1,It2_2,It3_1],Var_1034568234_2),getArrayElement(Self_data,[It_1,It2_2,It3_1],Var_835227336_2),getArrayElement(Result_data,[It_1,It2_2,It3_1],Var_482082765_2),(Var_482082765_2 #= (Var_835227336_2+Var_1034568234_2)),
(Index2_4 #= (Index2_3+1)),
(Index2_4 #> Dim3 - 1+ 1),
(Index1_4 #= (Index1_3+1)),
(Index1_4 #> Dim2 - 1+ 1),
(Index0_2 #= (Index0_1+1)),
(Index0_2 #> Dim1 - 1+ 1),

%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
