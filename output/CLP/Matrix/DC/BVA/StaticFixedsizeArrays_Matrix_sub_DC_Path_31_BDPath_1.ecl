:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

staticFixedsizeArrays_Matrix_sub_DC_Path_31_BDPath_1(Self,Arg,Result):-

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
nth1(1,Arg_dimensionSizes,Var_1754894440),
(Dim1 = Var_1754894440),
nth1(2,Arg_dimensionSizes,Var_1998767043),
(Dim2 = Var_1998767043),
(Acc = true),
(Idx0 #= 1),
(Idx0 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_787738361),nth1(Idx0,List_787738361,Var_787738361),(It = Var_787738361),
(Acc2 = true),
(Idx1 #= 1),
(Idx1 #=< Dim2 - 1+ 1),
sequencetoList(1,Dim2,List_607932305),nth1(Idx1,List_607932305,Var_607932305),(It2 = Var_607932305),
getArrayElement(Arg_data,[It,It2],Var_168366_1),getArrayElement(Self_data,[It,It2],Var_1642030774_1),getArrayElement(Result_data,[It,It2],Var_1357563986_1),(Var_1357563986_1 #= (Var_1642030774_1-Var_168366_1)),
(Idx1_1 #= (Idx1+1)),
(Idx1_1 #=< Dim2 - 1+ 1),
sequencetoList(1,Dim2,List_607932305),nth1(Idx1_1,List_607932305,Var_607932305_1),(It2_1 = Var_607932305_1),
getArrayElement(Arg_data,[It,It2_1],Var_168366_2),getArrayElement(Self_data,[It,It2_1],Var_1642030774_2),getArrayElement(Result_data,[It,It2_1],Var_1357563986_2),(Var_1357563986_2 #= (Var_1642030774_2-Var_168366_2)),
(Idx1_2 #= (Idx1_1+1)),
(Idx1_2 #> Dim2 - 1+ 1),
(Idx0_1 #= (Idx0+1)),
(Idx0_1 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_787738361),nth1(Idx0_1,List_787738361,Var_787738361_1),(It_1 = Var_787738361_1),
(Acc2_1 = true),
(Idx1_3 #= 1),
(Idx1_3 #=< Dim2 - 1+ 1),
sequencetoList(1,Dim2,List_607932305),nth1(Idx1_3,List_607932305,Var_607932305_2),(It2_2 = Var_607932305_2),
getArrayElement(Arg_data,[It_1,It2_2],Var_168366_3),getArrayElement(Self_data,[It_1,It2_2],Var_1642030774_3),getArrayElement(Result_data,[It_1,It2_2],Var_1357563986_3),(Var_1357563986_3 #= (Var_1642030774_3-Var_168366_3)),
(Idx1_4 #= (Idx1_3+1)),
(Idx1_4 #=< Dim2 - 1+ 1),
sequencetoList(1,Dim2,List_607932305),nth1(Idx1_4,List_607932305,Var_607932305_3),(It2_3 = Var_607932305_3),
getArrayElement(Arg_data,[It_1,It2_3],Var_168366_4),getArrayElement(Self_data,[It_1,It2_3],Var_1642030774_4),getArrayElement(Result_data,[It_1,It2_3],Var_1357563986_4),(Var_1357563986_4 #= (Var_1642030774_4-Var_168366_4)),
(Idx1_5 #= (Idx1_4+1)),
(Idx1_5 #> Dim2 - 1+ 1),
(Idx0_2 #= (Idx0_1+1)),
(Idx0_2 #> Dim1 - 1+ 1),

%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
