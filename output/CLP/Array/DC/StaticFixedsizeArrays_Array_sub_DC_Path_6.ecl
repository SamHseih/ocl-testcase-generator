:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

staticFixedsizeArrays_Array_sub_DC_Path_6(Self,Arg,Result):-

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
nth1(1,Arg_dimensionSizes,Var_1984990929),
(Dim1 = Var_1984990929),
(Acc = true),
(Idx0 #= 1),
(Idx0 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_1105423942),nth1(Idx0,List_1105423942,Var_1105423942),(It = Var_1105423942),
getArrayElement(Arg_data,[It],Var_365181913_1),getArrayElement(Self_data,[It],Var_1031061344_1),getArrayElement(Result_data,[It],Var_1327536153_1),(Var_1327536153_1 #= (Var_1031061344_1-Var_365181913_1)),
(Idx0_1 #= (Idx0+1)),
(Idx0_1 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_1105423942),nth1(Idx0_1,List_1105423942,Var_1105423942_1),(It_1 = Var_1105423942_1),
getArrayElement(Arg_data,[It_1],Var_365181913_2),getArrayElement(Self_data,[It_1],Var_1031061344_2),getArrayElement(Result_data,[It_1],Var_1327536153_2),(Var_1327536153_2 #= (Var_1031061344_2-Var_365181913_2)),
(Idx0_2 #= (Idx0_1+1)),
(Idx0_2 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_1105423942),nth1(Idx0_2,List_1105423942,Var_1105423942_2),(It_2 = Var_1105423942_2),
getArrayElement(Arg_data,[It_2],Var_365181913_3),getArrayElement(Self_data,[It_2],Var_1031061344_3),getArrayElement(Result_data,[It_2],Var_1327536153_3),(Var_1327536153_3 #= (Var_1031061344_3-Var_365181913_3)),
(Idx0_3 #= (Idx0_2+1)),
(Idx0_3 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_1105423942),nth1(Idx0_3,List_1105423942,Var_1105423942_3),(It_3 = Var_1105423942_3),
getArrayElement(Arg_data,[It_3],Var_365181913_4),getArrayElement(Self_data,[It_3],Var_1031061344_4),getArrayElement(Result_data,[It_3],Var_1327536153_4),(Var_1327536153_4 #= (Var_1031061344_4-Var_365181913_4)),
(Idx0_4 #= (Idx0_3+1)),
(Idx0_4 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_1105423942),nth1(Idx0_4,List_1105423942,Var_1105423942_4),(It_4 = Var_1105423942_4),
getArrayElement(Arg_data,[It_4],Var_365181913_5),getArrayElement(Self_data,[It_4],Var_1031061344_5),getArrayElement(Result_data,[It_4],Var_1327536153_5),(Var_1327536153_5 #= (Var_1031061344_5-Var_365181913_5)),
(Idx0_5 #= (Idx0_4+1)),
(Idx0_5 #> Dim1 - 1+ 1),

%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
