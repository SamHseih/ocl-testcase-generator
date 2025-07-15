:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(random).

staticFixedsizeArrays_Array_add_DC_Path_6(Self,Arg,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_datas,Self_dimensionSizes],Self_dimensionSizes = [5],
Arg=[Arg_datas,Arg_dimensionSizes],Arg_dimensionSizes = [5],
Result = [Result_datas,Result_dimensionSizes],Result_dimensionSizes = [5],

decl_Array(Self_datas,Self_dimensionSizes),
decl_Array(Arg_datas,Arg_dimensionSizes),
decl_Array(Result_datas,Result_dimensionSizes),

%CLG Path Constrints,
nth1(1,Arg_dimensionSizes,Var_1629687658),
(Dim1 = Var_1629687658),
(Acc = true),
(Idx0 #= 1),
(Idx0 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_431687661),nth1(Idx0,List_431687661,Var_431687661),(It = Var_431687661),
getArrayElement(Arg_datas,[It],Var_283383329_1),getArrayElement(Self_datas,[It],Var_893192050_1),getArrayElement(Result_datas,[It],Var_644345897_1),(Var_644345897_1 #= (Var_893192050_1+Var_283383329_1)),
(Idx0_1 #= (Idx0+1)),
(Idx0_1 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_431687661),nth1(Idx0_1,List_431687661,Var_431687661_1),(It_1 = Var_431687661_1),
getArrayElement(Arg_datas,[It_1],Var_283383329_2),getArrayElement(Self_datas,[It_1],Var_893192050_2),getArrayElement(Result_datas,[It_1],Var_644345897_2),(Var_644345897_2 #= (Var_893192050_2+Var_283383329_2)),
(Idx0_2 #= (Idx0_1+1)),
(Idx0_2 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_431687661),nth1(Idx0_2,List_431687661,Var_431687661_2),(It_2 = Var_431687661_2),
getArrayElement(Arg_datas,[It_2],Var_283383329_3),getArrayElement(Self_datas,[It_2],Var_893192050_3),getArrayElement(Result_datas,[It_2],Var_644345897_3),(Var_644345897_3 #= (Var_893192050_3+Var_283383329_3)),
(Idx0_3 #= (Idx0_2+1)),
(Idx0_3 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_431687661),nth1(Idx0_3,List_431687661,Var_431687661_3),(It_3 = Var_431687661_3),
getArrayElement(Arg_datas,[It_3],Var_283383329_4),getArrayElement(Self_datas,[It_3],Var_893192050_4),getArrayElement(Result_datas,[It_3],Var_644345897_4),(Var_644345897_4 #= (Var_893192050_4+Var_283383329_4)),
(Idx0_4 #= (Idx0_3+1)),
(Idx0_4 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_431687661),nth1(Idx0_4,List_431687661,Var_431687661_4),(It_4 = Var_431687661_4),
getArrayElement(Arg_datas,[It_4],Var_283383329_5),getArrayElement(Self_datas,[It_4],Var_893192050_5),getArrayElement(Result_datas,[It_4],Var_644345897_5),(Var_644345897_5 #= (Var_893192050_5+Var_283383329_5)),
(Idx0_5 #= (Idx0_4+1)),
(Idx0_5 #> Dim1 - 1+ 1),

%TypeVar Labeling Parts
labeling_Arrays([Self_datas, Arg_datas]).
