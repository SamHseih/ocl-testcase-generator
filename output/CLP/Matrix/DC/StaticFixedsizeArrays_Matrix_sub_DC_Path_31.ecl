:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

staticFixedsizeArrays_Matrix_sub_DC_Path_31(Self,Arg,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_data,Self_dimensionSizes],Self_dimensionSizes = [2, 2],
Arg=[Arg_data,Arg_dimensionSizes],Arg_dimensionSizes = [2, 2],
Result = [Result_data,Result_dimensionSizes],Result_dimensionSizes = [2, 2],

decl_Array(Self_data,Self_dimensionSizes),
decl_Array(Arg_data,Arg_dimensionSizes),
decl_Array(Result_data,Result_dimensionSizes),

[]#::(-32768)..32767,
%CLG Path Constrints,
nth1(1,Arg_dimensionSizes,Var_365181913),
(Dim1 = Var_365181913),
nth1(2,Arg_dimensionSizes,Var_1031061344),
(Dim2 = Var_1031061344),
(Acc = true),
(Idx0 #= 1),
(Idx0 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_1327536153),nth1(Idx0,List_1327536153,Var_1327536153),(It = Var_1327536153),
(Acc2 = true),
(Idx1 #= 1),
(Idx1 #=< Dim2 - 1+ 1),
sequencetoList(1,Dim2,List_367746789),nth1(Idx1,List_367746789,Var_367746789),(It2 = Var_367746789),
getArrayElement(Arg_data,[It,It2],Var_558216562_1),getArrayElement(Self_data,[It,It2],Var_961712517_1),getArrayElement(Result_data,[It,It2],Var_1928931046_1),(Var_1928931046_1 #= (Var_961712517_1-Var_558216562_1)),
(Idx1_1 #= (Idx1+1)),
(Idx1_1 #=< Dim2 - 1+ 1),
sequencetoList(1,Dim2,List_367746789),nth1(Idx1_1,List_367746789,Var_367746789_1),(It2_1 = Var_367746789_1),
getArrayElement(Arg_data,[It,It2_1],Var_558216562_2),getArrayElement(Self_data,[It,It2_1],Var_961712517_2),getArrayElement(Result_data,[It,It2_1],Var_1928931046_2),(Var_1928931046_2 #= (Var_961712517_2-Var_558216562_2)),
(Idx1_2 #= (Idx1_1+1)),
(Idx1_2 #> Dim2 - 1+ 1),
(Idx0_1 #= (Idx0+1)),
(Idx0_1 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_1327536153),nth1(Idx0_1,List_1327536153,Var_1327536153_1),(It_1 = Var_1327536153_1),
(Acc2_1 = true),
(Idx1_3 #= 1),
(Idx1_3 #=< Dim2 - 1+ 1),
sequencetoList(1,Dim2,List_367746789),nth1(Idx1_3,List_367746789,Var_367746789_2),(It2_2 = Var_367746789_2),
getArrayElement(Arg_data,[It_1,It2_2],Var_558216562_3),getArrayElement(Self_data,[It_1,It2_2],Var_961712517_3),getArrayElement(Result_data,[It_1,It2_2],Var_1928931046_3),(Var_1928931046_3 #= (Var_961712517_3-Var_558216562_3)),
(Idx1_4 #= (Idx1_3+1)),
(Idx1_4 #=< Dim2 - 1+ 1),
sequencetoList(1,Dim2,List_367746789),nth1(Idx1_4,List_367746789,Var_367746789_3),(It2_3 = Var_367746789_3),
getArrayElement(Arg_data,[It_1,It2_3],Var_558216562_4),getArrayElement(Self_data,[It_1,It2_3],Var_961712517_4),getArrayElement(Result_data,[It_1,It2_3],Var_1928931046_4),(Var_1928931046_4 #= (Var_961712517_4-Var_558216562_4)),
(Idx1_5 #= (Idx1_4+1)),
(Idx1_5 #> Dim2 - 1+ 1),
(Idx0_2 #= (Idx0_1+1)),
(Idx0_2 #> Dim1 - 1+ 1),

%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
