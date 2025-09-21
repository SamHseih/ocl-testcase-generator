:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

staticFixedsizeArrays_Array_add_DC_Path_6(Self,Arg,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_data,Self_dimensionSizes],Self_dimensionSizes = [5],
Arg=[Arg_data,Arg_dimensionSizes],Arg_dimensionSizes = [5],
Result = [Result_data,Result_dimensionSizes],Result_dimensionSizes = [5],

decl_Array(Self_data,Self_dimensionSizes),
decl_Array(Arg_data,Arg_dimensionSizes),
decl_Array(Result_data,Result_dimensionSizes),

[]#::(-32768)..32767,
%CLG Path Constrints,
nth1(1,Arg_dimensionSizes,Var_1781071780),
(Dim1 = Var_1781071780),
(Acc = true),
(Idx0 #= 1),
(Idx0 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_388357135),nth1(Idx0,List_388357135,Var_388357135),(It = Var_388357135),
getArrayElement(Arg_data,[It],Var_957465255_1),getArrayElement(Self_data,[It],Var_1254344205_1),getArrayElement(Result_data,[It],Var_1336735375_1),(Var_1336735375_1 #= (Var_1254344205_1+Var_957465255_1)),
(Idx0_1 #= (Idx0+1)),
(Idx0_1 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_388357135),nth1(Idx0_1,List_388357135,Var_388357135_1),(It_1 = Var_388357135_1),
getArrayElement(Arg_data,[It_1],Var_957465255_2),getArrayElement(Self_data,[It_1],Var_1254344205_2),getArrayElement(Result_data,[It_1],Var_1336735375_2),(Var_1336735375_2 #= (Var_1254344205_2+Var_957465255_2)),
(Idx0_2 #= (Idx0_1+1)),
(Idx0_2 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_388357135),nth1(Idx0_2,List_388357135,Var_388357135_2),(It_2 = Var_388357135_2),
getArrayElement(Arg_data,[It_2],Var_957465255_3),getArrayElement(Self_data,[It_2],Var_1254344205_3),getArrayElement(Result_data,[It_2],Var_1336735375_3),(Var_1336735375_3 #= (Var_1254344205_3+Var_957465255_3)),
(Idx0_3 #= (Idx0_2+1)),
(Idx0_3 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_388357135),nth1(Idx0_3,List_388357135,Var_388357135_3),(It_3 = Var_388357135_3),
getArrayElement(Arg_data,[It_3],Var_957465255_4),getArrayElement(Self_data,[It_3],Var_1254344205_4),getArrayElement(Result_data,[It_3],Var_1336735375_4),(Var_1336735375_4 #= (Var_1254344205_4+Var_957465255_4)),
(Idx0_4 #= (Idx0_3+1)),
(Idx0_4 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_388357135),nth1(Idx0_4,List_388357135,Var_388357135_4),(It_4 = Var_388357135_4),
getArrayElement(Arg_data,[It_4],Var_957465255_5),getArrayElement(Self_data,[It_4],Var_1254344205_5),getArrayElement(Result_data,[It_4],Var_1336735375_5),(Var_1336735375_5 #= (Var_1254344205_5+Var_957465255_5)),
(Idx0_5 #= (Idx0_4+1)),
(Idx0_5 #> Dim1 - 1+ 1),

%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
