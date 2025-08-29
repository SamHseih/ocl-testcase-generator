:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

staticFixedsizeArrays_Array_sub_DC_Path_6(Self,Arg,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_datas,Self_dimensionSizes],Self_dimensionSizes = [5],
Arg=[Arg_datas,Arg_dimensionSizes],Arg_dimensionSizes = [5],
Result = [Result_datas,Result_dimensionSizes],Result_dimensionSizes = [5],

decl_Array(Self_datas,Self_dimensionSizes),
decl_Array(Arg_datas,Arg_dimensionSizes),
decl_Array(Result_datas,Result_dimensionSizes),

[]#::(-32768)..32767,
%CLG Path Constrints,
nth1(1,Arg_dimensionSizes,Var_1357563986),
(Dim1 = Var_1357563986),
(Acc = true),
(Idx0 #= 1),
(Idx0 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_384587033),nth1(Idx0,List_384587033,Var_384587033),(It = Var_384587033),
getArrayElement(Arg_datas,[It],Var_49752459_1),getArrayElement(Self_datas,[It],Var_411506101_1),getArrayElement(Result_datas,[It],Var_514455215_1),(Var_514455215_1 #= (Var_411506101_1-Var_49752459_1)),
(Idx0_1 #= (Idx0+1)),
(Idx0_1 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_384587033),nth1(Idx0_1,List_384587033,Var_384587033_1),(It_1 = Var_384587033_1),
getArrayElement(Arg_datas,[It_1],Var_49752459_2),getArrayElement(Self_datas,[It_1],Var_411506101_2),getArrayElement(Result_datas,[It_1],Var_514455215_2),(Var_514455215_2 #= (Var_411506101_2-Var_49752459_2)),
(Idx0_2 #= (Idx0_1+1)),
(Idx0_2 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_384587033),nth1(Idx0_2,List_384587033,Var_384587033_2),(It_2 = Var_384587033_2),
getArrayElement(Arg_datas,[It_2],Var_49752459_3),getArrayElement(Self_datas,[It_2],Var_411506101_3),getArrayElement(Result_datas,[It_2],Var_514455215_3),(Var_514455215_3 #= (Var_411506101_3-Var_49752459_3)),
(Idx0_3 #= (Idx0_2+1)),
(Idx0_3 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_384587033),nth1(Idx0_3,List_384587033,Var_384587033_3),(It_3 = Var_384587033_3),
getArrayElement(Arg_datas,[It_3],Var_49752459_4),getArrayElement(Self_datas,[It_3],Var_411506101_4),getArrayElement(Result_datas,[It_3],Var_514455215_4),(Var_514455215_4 #= (Var_411506101_4-Var_49752459_4)),
(Idx0_4 #= (Idx0_3+1)),
(Idx0_4 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_384587033),nth1(Idx0_4,List_384587033,Var_384587033_4),(It_4 = Var_384587033_4),
getArrayElement(Arg_datas,[It_4],Var_49752459_5),getArrayElement(Self_datas,[It_4],Var_411506101_5),getArrayElement(Result_datas,[It_4],Var_514455215_5),(Var_514455215_5 #= (Var_411506101_5-Var_49752459_5)),
(Idx0_5 #= (Idx0_4+1)),
(Idx0_5 #> Dim1 - 1+ 1),

%TypeVar Labeling Parts
labeling_Arrays([Self_datas, Arg_datas]).
